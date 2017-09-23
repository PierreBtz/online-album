import React, {Component} from 'react';
import {withStyles} from 'material-ui/styles';
import PropTypes from 'prop-types';
import {FormLabel} from 'material-ui/Form';
import TextField from 'material-ui/TextField';
import Button from 'material-ui/Button';
import 'whatwg-fetch';
import {SERVER_URL} from './config';

class AddAlbum extends Component {

    constructor(props) {
        super(props);
        this.state = {name: ''};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({name: event.target.value});
    }

    handleSubmit(event) {
        const albumName = this.state.name;
        const data = new FormData();
        data.append('name', albumName);
        data.append('description', 'default description');
        fetch(`${SERVER_URL}/albums`, {
            method: 'POST',
            body: data
        });
        event.preventDefault();
    }

    render() {
        const classes = this.props.classes;
        return (
            <form onSubmit={this.handleSubmit}>
                <FormLabel>
                    Name:
                    <TextField type="text" color="primary" value={this.state.name} onChange={this.handleChange}/>
                </FormLabel>
                <br/>
                <Button type="Submit" raised className={classes.button}>Create</Button>
            </form>
        );
    }
}

AddAlbum.propTypes = {
    classes: PropTypes.object.isRequired,
};

const styles = theme => ({
    button: {
        margin: theme.spacing.unit,
    }
});

export default withStyles(styles)(AddAlbum);