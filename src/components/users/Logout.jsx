import React, { useEffect } from 'react'
import useAuth from '../../hooks/useAuth'
import { useNavigate } from 'react-router-dom';

export const Logout = () => {

const {setAuth}=useAuth();
const navigate =useNavigate();

useEffect(()=>{
  //VACIAR EL LOCAL STORAGE
localStorage.clear();

  //setear estados globales a vacia
setAuth({});
  //Navigate (redireccion) al login
  navigate("/login");
})

  return (
    <h1>Cerrando sesión</h1>
  )
}
