import React from 'react';
import MenuButton from "../components/MenuButton";
import { useNavigate } from "react-router-dom";

function Menu() {
    const navigate = useNavigate();

    return (
        <div className="menu">
            <MenuButton text="Play whites" theme="light" onClick={() => navigate("/whites")} />
            <MenuButton text="Play blacks" theme="dark" onClick={() => navigate("/blacks")} />
        </div>
    );
}

export default Menu;