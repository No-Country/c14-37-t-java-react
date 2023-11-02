import React from "react";
import { Routes, Route, BrowserRouter, Navigate, Link } from "react-router-dom";
import { Inicio } from "../components/pages/Inicio";
import { Quienessomos } from "../components/pages/Quienessomos";
import { Productos } from "../components/pages/Productos";
import { Contacto } from "../components/pages/Contacto";
// import { Login } from "../components/pages/Login";
import { Nav } from "../components/layout/public/Nav";
import { Footer } from "../components/layout/Footer";
// import { Register } from "../components/pages/Register";
import { Sidebar } from "../components/layout/Sidebar";
import { MiPerfil } from "../components/pages/MiPerfil";
import { Mislistas } from "../components/pages/Mislistas";
import { NavPrivate } from "../components/layout/private/NavPrivate";
import { PublicLayout } from "../components/layout/public/PublicLayout";
import { PrivateLayout } from "../components/layout/private/PrivateLayout";
import { Login } from "../components/users/Login";
import { Register } from "../components/users/Register";
import { AuthProvider } from "../context/AuthProvider";
import { Logout } from "../components/users/Logout";
import { Config } from "../components/users/Config";
import { MiLista } from "../components/pages/MiLista";




export const Rutas = () => {
  return (
    <BrowserRouter>
      {/* LAYAOUT*/}
      {/* <Nav /> */}
    
    <AuthProvider>

      {/* CONTENIDO CENTRAL Y RUTAS */}

      <section id="content" className="content">
        <Routes>
          <Route path="/" element={<PublicLayout />}>
            {/* <Route path="/" element={<Inicio />} /> */}
            <Route index element={<Inicio />} />
            <Route path="inicio" element={<Inicio />} />
            <Route path="quienessomos" element={<Quienessomos />} />
            {/* <Route path="mislistas/:memberId" element={<MiLista />} /> */}
            {/*       <Route path="/miperfil" element={<MiPerfil />} />
          <Route path="/mislistas" element={<Mislistas />} /> */}
            <Route path="contacto" element={<Contacto />} />
            <Route path="login" element={<Login />} />
            <Route path="register" element={<Register />} />
          </Route>


          <Route path="/social" element={<PrivateLayout/>}>
          <Route index element={<Mislistas/>} />
          <Route path="miperfil" element={<MiPerfil />} />
          {/* <Route path="/mislistas" element={<Mislistas />} /> */}
          <Route path="inicio" element={<Inicio />} />
          
          
{/*

          <Route path="mislistas" element={<Mislistas />} />
*/}
         
          <Route path="quienessomos" element={<Quienessomos />} />
          <Route path="contacto" element={<Contacto />} />
          <Route path="logout" element={<Logout/>} />
          <Route path="config" element={<Config/>} />



          </Route>

          <Route
            path="*"
            element={
              <div className="jumbo">
                <h1>Error 404</h1>
                <Link to='/'>Volver al inicio</Link>
              </div>
            }
          />
        </Routes>
      </section>
      </AuthProvider>
      {/* <Footer /> */}
    </BrowserRouter>
  );
};
