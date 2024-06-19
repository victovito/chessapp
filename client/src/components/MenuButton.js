import React from 'react';

/**
 * @typedef MenuButtonProps
 * @prop {string} text
 * @prop {() => void} onClick
 * @prop {"light" | "dark"} theme
 */

/** @param {MenuButtonProps} param0 */
function MenuButton({ text, onClick, theme }) {
    return (
        <button className={theme} onClick={onClick}>
            {text}
        </button>
    );
}

export default MenuButton;