import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const Login = () => {
      const navigate=useNavigate();
    const [formData,setFormData]=useState({
        "username":"",
        "password":""
    })
     const update=(e)=>{
        setFormData({...formData,[e.target.name]:e.target.value});
    }
    const login=(e)=>{
        e.preventDefault();
        axios.post("http://localhost:9091/login", {
      username: formData["username"],
      password:formData["password"]
    })
    .then(response => {
      localStorage.setItem("token",response.data);
      navigate("/home")
      
    })
    .catch(error => {
        alert("please enter correct username or password" + error)
    });
        
    }
  return (
    <div className='login'>
        <h1>Hey Login</h1>

        <form className='login-form' action="" onSubmit={(e)=>login(e)}>

        <input  type="text" placeholder='Enter username' id="username" name="username" value={formData["username"]} onChange={(e)=>update(e)}/>
        <br />
        <input  type="text" placeholder='Enter password' id="password" name="password" value={formData["password"]} onChange={(e)=>update(e)}/>
        <br />
        <button   >submit</button>



        </form>

    </div>
  )
}

export default Login