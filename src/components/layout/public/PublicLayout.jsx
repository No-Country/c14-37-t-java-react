import React from 'react'
import { Nav } from './Nav'
import { Navigate, Outlet } from 'react-router-dom'
import useAuth from '../../../hooks/useAuth'

export const PublicLayout = () => {

  const {auth}=useAuth();

  return (
    <>
    {/* LAYOUT*/}
    <Nav/>
  {/* CONTENIDO PRINCIPAL*/}
  <section className='layout_contentt'>
  {/* {!auth._id ? */}
   <Outlet/>
   {/* :
   <Navigate to="/social" />
  }
  */}
  </section>

    </>
  )
}
