import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {withStyles} from 'material-ui/styles';
import Button from 'material-ui/Button';
import AddIcon from 'material-ui-icons/Add';
import {Link} from 'react-router-dom'

class AddButton extends Component {

    render() {
        const classes = this.props.classes;
        return (
            <div>
                <Link to="/add"><Button fab color="primary" aria-label="add" className={classes.button}>
                    <AddIcon/>
                </Button></Link>
            </div>);
    }
}

AddButton.propTypes = {
    classes: PropTypes.object.isRequired,
};

const styles = theme => ({
    // using the styles found here:
    // https://stackoverflow.com/questions/35828991/make-material-ui-reactjs-floatingactionbutton-float
    button: {
        margin: 0,
        top: 'auto',
        right: 20,
        bottom: 20,
        left: 'auto',
        position: 'fixed',
    },
});

export default withStyles(styles)(AddButton);
