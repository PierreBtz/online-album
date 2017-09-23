import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {withStyles} from 'material-ui/styles';
import List, {ListItem, ListItemText} from 'material-ui/List';
import Avatar from 'material-ui/Avatar';
import FolderIcon from 'material-ui-icons/Folder';

import {withRouter} from 'react-router-dom'


class AlbumList extends Component {

    constructor() {
        super();
        this.handleClick.bind(this);
    }

    handleClick(event, key) {
        console.log(key);
        this.props.history.push(`/album?id=${key}`)
        event.preventDefault();
    }

    render() {
        const classes = this.props.classes;
        const albums = this.props.albums;
        let rows = [];
        albums.forEach(album => {
            rows.push(
                <ListItem button key={album.name} onClick={event => this.handleClick(event, album.name)}>
                    <Avatar>
                        <FolderIcon/>
                    </Avatar>
                    <ListItemText primary={album.name} secondary={album.description}/>
                </ListItem>)
        });
        return (
            <div className={classes.root}>
                <List>
                    {rows}
                </List>
            </div>
        );
    }
}

AlbumList.propTypes = {
    classes: PropTypes.object.isRequired,
    albums: PropTypes.array.isRequired
};

const styles = theme => ({
    root: {
        width: '100%',
        maxWidth: 360,
        background: theme.palette.background.paper
    },
});

export default withStyles(styles)(withRouter(AlbumList));