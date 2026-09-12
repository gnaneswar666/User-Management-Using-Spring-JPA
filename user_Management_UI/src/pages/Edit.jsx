import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { api } from '../services/userManagament';
import { useNavigate } from 'react-router-dom';
const Edit = () => {
    const {id}=useParams();
    const [data,setData]=useState({});
    const navigate = useNavigate();
    useEffect(()=>{
        axios.get(`${api}/${id}`)
        .then(res=>setData(res.data))
        .catch(e=>console.log(e))
    },[id]);


    const update=(e)=>{
        setData({...data,[e.target.name]:e.target.value});
    }
    const submit=(e)=>{
        e.preventDefault();
        axios.put(`${api}/${id}`,{
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
  return (
    <div class="container">
        
        <form action="" onSubmit={(e)=>submit(e)} class="container">

            <div class="mb-3">
                {/* <label for="name" class="form-label">Enter the name</label> */}
                <input  type="text" class="form-control" name="name" value={data["name"]} onChange={(e)=>update(e)} placeholder="Enter the name" />
                </div>
                <div class="mb-3">
                {/* <label for="email" class="form-label">Email</label> */}
                <input type="email" class="form-control" value={data["email"]} name="email" placeholder="Enter Email"  onChange={(e)=>update(e)}/>
                </div>

                 <div class="mb-3">
                {/* <label for="name" class="form-label">Enter the Age</label> */}
                <input  type="Number" class="form-control" name="age" value={data["age"]}onChange={(e)=>update(e)} placeholder="Enter the name" />
                </div>
                 <div class="mb-3">
                {/* <label for="name" class="form-label">Enter the Age</label> */}
                <input  type="password" class="form-control" name="password" value={data["password"]}onChange={(e)=>update(e)} placeholder="Enter the Password" />
                </div>
                <input type="submit" />
                




        </form>



    </div>
  )
}

export default Edit