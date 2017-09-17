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
    button: {
        margin: theme.spacing.unit
    },
});

export default withStyles(styles)(AddButton);
