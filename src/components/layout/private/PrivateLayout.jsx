


import React from 'react'
import { Navigate, Outlet } from 'react-router-dom'
import { NavPrivate } from './NavPrivate'
import useAuth from '../../../hooks/useAuth' 
import NavPriv from './NavPriv'

export const PrivateLayout = () => {

const {auth, loading}=useAuth();

if(loading){
  return <h1>Cargando .....</h1>
}else{

  return (
    <>
    {/* LAYOUT navegacion*/}
    {/* <NavPrivate/> */}
    <NavPriv/>
  {/* CONTENIDO PRINCIPAL*/}
  <section className='layout_contentt'>
    {/* {auth._id ? */}
    <Outlet/>
    {/* : */}
    {/* <Navigate to="/login"/> */}
    
    {/* } */}
  
  </section>

    </>
  );
}
}
