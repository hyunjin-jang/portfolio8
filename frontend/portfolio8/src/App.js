import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route, Link, useNavigate } from 'react-router-dom'
import Detail from './pages/Detail';
import Main from './pages/Main';
import Join from './pages/Join';
import Login from './pages/Login';
import Navbar from './component/Navbar'

function App() {
  let navigate = useNavigate()

  return (
    <div className="App">
      <Navbar/>
      <button onClick={()=>{ navigate('/detail') }}>Detail</button>

      <Routes>
        <Route path='*' element={ <div>404 없는 페이지임</div> }/>
        <Route path='/' element={<Main/>}/>
        <Route path='/detail' element={<Detail/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/join' element={<Join/>}/>
      </Routes>
    </div>
  );
}

export default App;
