import React from 'react';
import { Link } from 'react-router-dom';

type Props = {
    link: string,
    textLink: string
}

const Filters = ({ link, textLink }: Props) => {
    return (
        <div className="filters-container records-actions">
        <Link to={link}>
            <button className="action-filters">
                {textLink}
            </button>
        </Link>
        </div>
    );
}

export default Filters;