import React, {Component} from 'react';
import {withStyles} from 'material-ui/styles';
import queryString from 'query-string';

class Album extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const classes = this.props.classes;
        return (
            <div>
                {queryString.parse(this.props.location.search).id}
            </div>);
    }
}

Album.propTypes = {};

const styles = theme => ({}
);

export default withStyles(styles)(Album);