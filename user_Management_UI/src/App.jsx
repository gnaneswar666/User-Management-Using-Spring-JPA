import { RouterProvider, createBrowserRouter } from "react-router-dom";
import Home from "./pages/Home.jsx";
import Edit from "./pages/Edit.jsx";
import AddUser from "./pages/AddUser.jsx";
import Login from "./pages/Login.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Login />
  },
  {
    path: "/home",
    element: <Home />
  },
  {
    path: "/home/edit/:id",
    element: <Edit />
  },
  {
    path: "/addUser",
    element: <AddUser />
  }
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;