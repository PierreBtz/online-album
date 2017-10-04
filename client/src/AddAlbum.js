import React, {Component} from 'react';
import {withStyles} from 'material-ui/styles';
import PropTypes from 'prop-types';
import {FormLabel} from 'material-ui/Form';
import TextField from 'material-ui/TextField';
import Button from 'material-ui/Button';
import 'whatwg-fetch';
import {SERVER_URL} from './config';

import {withRouter} from 'react-router-dom'

class AddAlbum extends Component {

    constructor(props) {
        super(props);
        this.state = {name: '', description: ''};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        if (target.id === 'name') {
            this.setState({name: target.value});
        } else if (target.id === 'description') {
            this.setState({description: target.value});
        }
    }

    handleSubmit(event) {
        const albumName = this.state.name;
        const albumDescription = this.state.description;
        const data = new FormData();
        data.append('name', albumName);
        data.append('description', albumDescription);
        fetch(`${SERVER_URL}/albums`, {
            method: 'POST',
            body: data
        })
            .then(r => this.handleResponse(r))
            .catch(error => console.log('Error connecting to server: ' + error));
        event.preventDefault();
    }

    handleResponse(r) {
        if (r.ok) {
            this.props.history.push('/')
        } else {
            console.log('FAILURE');
        }
    }

    render() {
        const classes = this.props.classes;
        return (
            <form onSubmit={this.handleSubmit}>
                <FormLabel>
                    Name:
                    <TextField id="name" type="text" color="primary" value={this.state.name}
                               onChange={this.handleChange}/>
                </FormLabel>
                <br/>
                <FormLabel>
                    Description:
                    <TextField id="description" type="text" color="primary" value={this.state.description}
                               onChange={this.handleChange}/>
                </FormLabel>
                <br/>
                <Button type="Submit" raised className={classes.button}>Create</Button>
            </form>
        );
    }
}

AddAlbum.propTypes = {
    classes: PropTypes.object.isRequired,
    history: React.PropTypes.object.isRequired
};

const styles = theme => ({
    button: {
        margin: theme.spacing.unit,
    }
});

export default withStyles(styles)(withRouter(AddAlbum));