import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {withStyles} from 'material-ui/styles';
import List, {ListItem, ListItemText} from 'material-ui/List';
import Avatar from 'material-ui/Avatar';
import FolderIcon from 'material-ui-icons/Folder';

class AlbumList extends Component {

    constructor() {
        super();
    }

    render() {
        const classes = this.props.classes;
        const albums = this.props.albums;
        let rows = [];
        albums.forEach(album => {
            rows.push(
                <ListItem button>
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
    albums: PropTypes.object.isRequired
};

const styles = theme => ({
    root: {
        width: '100%',
        maxWidth: 360,
        background: theme.palette.background.paper,
    },
});

export default withStyles(styles)(AlbumList);