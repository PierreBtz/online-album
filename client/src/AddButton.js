import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {withStyles} from 'material-ui/styles';
import Button from 'material-ui/Button';
import AddIcon from 'material-ui-icons/Add';

class AddButton extends Component {

    render() {
        const classes = this.props.classes;
        return (
            <div>
                <Button fab color="primary" aria-label="add" className={classes.button}>
                    <AddIcon/>
                </Button>
            </div>);
    }
}

AddButton.propTypes = {
    classes: PropTypes.object.isRequired,
};

const styles = theme => ({
    button: {
        margin: theme.spacing.unit,
    },
});

export default withStyles(styles)(AddButton);
