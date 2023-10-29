import React from 'react'
import { Link } from "react-router-dom";
import { Routes, Route, BrowserRouter, Navigate } from "react-router-dom";
import { Footer } from '../layout/Footer';
import { Nav } from '../layout/public/Nav';

export const Inicio = () => {
  return (
    
    <>
    {/* <Nav /> */}
  <section>
      <div className="content">
    <img class="piccon" src="/src/assets/img/piccon.png" alt="Texto alternativo de la imagen"/>
  
  
  </div> 
 

    
    <aside className="lateral">

    <form className="botonera">

        <h3 className="no-tienes-cuenta" >
            ¿No tienes cuenta? </h3>
            <Link to="/register">
        {/* <a href=""> */}
            <div className="button">

                <div className="rectangle-2">
                </div>
                <div className="register">
                    Registrarte </div>
            </div>
        {/* </a> */}
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
