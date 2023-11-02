import React from 'react'
import { Link } from "react-router-dom";
import { Routes, Route, BrowserRouter, Navigate } from "react-router-dom";
import { Footer } from '../layout/Footer';
import { Nav } from '../layout/public/Nav';
import Foot from '../layout/Foot';

export const Inicio = () => {
  return (
    
    <>
    {/* <Nav /> */}
 {/*    <h1 className="text-3xl font-bold underline text-red-900">
      Hello world!
    </h1> */}
 
 <section className="  mt-48  flex flex-col md:flex-row items-center justify-center">
  <div className="content    w-full md:w-1/2 mx-auto">
    <img className="mx-auto" src="/src/assets/img/piccon.png" alt="Texto alternativo de la imagen" />
  </div>

  <aside className=" w-full md:w-1/2 mt-4 md:mt-0 ">
    <form className="md:ml-4 ">
      <Link to="/register">
        <div className="button dark">
          <div className="rectangle-2"></div>
          <div className="register">Registrarte</div>
        </div>
      </Link>

      <h3 className="   md:mt-0">¿Ya tienes cuenta?</h3>

      <Link to="/login">
        <div className="button-1">
          <div className="rectangle-1"></div>
          <div className="join-today">Iniciar Sesión</div>
        </div>
      </Link>
    </form>
  </aside>
</section>
<footer className='mt-48  gap-y-24'>
<Foot />

</footer>
{/* <Foot/> */}
</>
    
  )
}
