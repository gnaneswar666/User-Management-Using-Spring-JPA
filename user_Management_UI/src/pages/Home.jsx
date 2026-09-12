import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { api } from '../services/userManagament';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link} from "react-router-dom"

import "../App.css"

const Home = () => {

  const [formdata,setFormData]=useState({
    name:"hello",
    email:"",
    age:"",
    password:""
  });
  const update=(e)=>{
    setFormData({...formdata,[e.target.name]:e.target.value})
  }
   const [data,setData]= useState([]);
   useEffect(()=>{
      axios.get(api)
      .then(res=>setData(res.data))
      .catch(e=>alert(e));
   },[]);

   const deleteUser=(id)=>{
    axios.delete(`${api}/${id}`)
    .then(res=>{
        if(res.status==200) {
            axios.get(api)
        .then(res=>setData(res.data))
        .catch(e=>alert(e));
            alert(`User : ${id}  Delete Succesfully `)
        }
    })
    .catch(e=>{
        alert("user cannot delete Please Try Later")
    })
   }
  return (
    <div>
        
        <h1 className='heading'>List of All users</h1>
        <p className="button-p"><Link to="/addUser"><button className="addUser-button">Add</button></Link></p>

        <table className="table">
          <thead>
              <tr>
                <th scope="col">Name</th>
                <th scope="col">Age</th>
                <th scope="col">Email</th>
                <th scope="col">PassWord</th>
                <th scope="col">Actions</th>
            </tr>
          </thead>

           <tbody>
             {
                data.map((row)=>(


                     <tr key={row.id}>
                        <td>{row.name}</td>
                        <td>{row.age}</td>
                        <td>{row.email}</td>
                        <td>{row.password}</td>
                        <td> <Link to={`edit/${row.id}`}><button className='edit'>Edit</button></Link> <button className="delete" onClick={()=>deleteUser(row.id)}>Delete</button> </td>
                    </tr>
                ))
            }
           </tbody>


        </table>


            


    
    </div>

  )                                                                                                                                                                                                                                                                                                                                                             
}

export default Home
