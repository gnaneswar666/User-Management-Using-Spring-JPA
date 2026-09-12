import axios from 'axios';
import React, { useState } from 'react'
import { api } from '../services/userManagament';
import { Link, useNavigate } from 'react-router-dom';
import "../App.css"
const AddUser = () => {
     const [data,setData]=useState({});
     const navigate=useNavigate();
  const submit=(e)=>{
        e.preventDefault();
        axios.post(`${api}`,{
                name:data["name"],
                age:data["age"],
                password:data["password"],
                email:data["email"]
        })
        .then(status=>{
            if(status.status==201){
                navigate("/")
            }
           
        })
        .catch(e=>alert(e))

    }
    const update=(e)=>{
        setData({...data,[e.target.name]:e.target.value});
    }
  return (
    <div className="addUser-container">
        <h1>Add User</h1>
        
        <form action="" onSubmit={(e)=>submit(e)}>

            <div className="mb-3">
                {/* <label for="name" className="form-label">Enter the name</label> */}
                <input  type="text" className="form-control" name="name" value={data["name"]} onChange={(e)=>update(e)} placeholder="Enter the name" />
                </div>
                <div className="mb-3">
                {/* <label for="email" className="form-label">Email</label> */}
                <input type="email" className="form-control" value={data["email"]} name="email" placeholder="Enter Email"  onChange={(e)=>update(e)}/>
                </div>

                 <div className="mb-3">
                {/* <label for="name" className="form-label">Enter the Age</label> */}
                <input  type="Number" className="form-control" name="age" value={data["age"]}onChange={(e)=>update(e)} placeholder="Enter the Age" />
                </div>
                 <div className="mb-3">
                {/* <label for="name" className="form-label">Enter the Age</label> */}
                <input  type="password" className="form-control" name="password" value={data["password"]}onChange={(e)=>update(e)} placeholder="Enter the Password" />
                </div>
                <input className='edit' type="submit" />
            <Link to="/">    <button className='delete'>cancel</button></Link>
                




        </form>



    </div>
  )
}

export default AddUser