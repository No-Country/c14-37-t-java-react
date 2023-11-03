/* import React from 'react'
import { Link } from "react-router-dom";
import { Routes, Route, BrowserRouter, Navigate } from "react-router-dom";
import { Footer } from '../layout/Footer';
import { Nav } from '../layout/public/Nav';

export const Inicio = () => {
  return (
    
    <>

  <section>
      <div className="content">
    <img class="piccon" src="/src/assets/img/piccon.png" alt="Texto alternativo de la imagen"/>
  
  
  </div> 
 

    
    <aside className="lateral">

    <form className="botonera">

        <h3 className="no-tienes-cuenta" >
            ¿No tienes cuenta? </h3>
            <Link to="/register">
      
            <div className="button">

                <div className="rectangle-2">
                </div>
                <div className="register">
                    Registrarte </div>
            </div>
      
        </Link>

        <h3  className="ya-tienes-cuenta" >
            ¿Ya tienes cuenta? </h3>

            
            <Link to="/login">

            <div className="button-1">
                <div className="rectangle-1">
                </div>
                <div className="join-today">
                    Iniciar Sesión </div>
            </div>
            </Link>

    </form>
 

</aside>
  
</section>

<Footer />
</>
    
  )
}
 */



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
 
 <section className=" mt-40 sm:mt-12 md:mt-24 flex flex-col sm:flex-row items-center justify-center">
  <div className="w-full sm:w-1/2">
    <img className="mx-auto" src="/src/assets/img/welcome.png" alt="Texto alternativo de la imagen" />
  </div>
  
  <div className="w-full sm:w-1/2  mx-20 my-9">
    <img className="mx-auto" src="/src/assets/img/manlog3.png" alt="Texto alternativo de la imagen" />
  </div>

  <aside className="w-full sm:w-1/2 mt-4 sm:mt-0">
    <form className="sm:ml-4">

    <h3 className="mt-4  mx-16 sm:mt-0  text-blue-700  "> ¿No tienes cuenta?</h3>
    
      <Link to="/register">
        <div className="button dark">
          <div className="rectangle-2"></div>
          <div className="register">Registrarte</div>
        </div>
      </Link>

      <h3 className="mt-4 mx-20 sm:mt-0">¿Ya tienes cuenta?</h3>

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
