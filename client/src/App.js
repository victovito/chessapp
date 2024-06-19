import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Match from './screens/Match';
import Menu from "./screens/Menu";

function App() {
  return (
    <div className="app">
      <Routes>
        <Route path="/" element={<Menu />} />
        <Route path='/whites' element={<Match player="WHITE" />} />
        <Route path='/blacks' element={<Match player="BLACK" />} />
      </Routes>
    </div>
  );
}

export default App;
