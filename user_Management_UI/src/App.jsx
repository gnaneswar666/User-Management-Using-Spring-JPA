import React, { useEffect, useState } from 'react'
import {api} from "./services/userManagament.js"
import Home from "../src/pages/Home.jsx"
  import { RouterProvider ,createBrowserRouter } from 'react-router-dom'
import Edit from './pages/Edit.jsx';
import AddUser from './pages/AddUser.jsx';

const router=createBrowserRouter([


  {

    path:"/",
    element: <div>
      <Home/>
    </div>
  },
  {
      path:"/edit/:id",
    element: <div>
      <Edit/>
    </div>
  },
  {
    path:"/addUser",
    element:<div> 
      <AddUser/>
    </div>
  }

]);
const App=()=>{
  return(
      <RouterProvider router={router}></RouterProvider>
  )
}
export default App;
