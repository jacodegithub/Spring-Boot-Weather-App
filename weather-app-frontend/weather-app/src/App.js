import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './App.css';
import { Navbar } from './components/Navbar/Navbar';
// import { Body } from './components/Body/Body';

function App() {
  return (
    <div className="App">
      <Navbar />
      <ToastContainer
        position="bottom-center"
        autoClose={2000}
        closeOnClick
        pauseOnHover
        theme="light"
      />
      {/* <Body /> */}
    </div>
  );
}

export default App;
