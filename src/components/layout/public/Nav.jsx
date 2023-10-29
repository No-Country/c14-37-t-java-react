import React from 'react'
import { NavLink } from 'react-router-dom'

export const Nav = () => {
  return (

    


<nav className="nav">

           


<ul>

    <li>
    <NavLink to="/inicio" >
        <div className="sample-logo1">
            <div className="photo1">
                LOGO </div>
            <svg className="unionp" width="26" height="16" viewBox="0 0 26 16" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd"
                    d="M18.0435 0.944458H2.47955e-05L7.59729 5.32306H25.6408L18.0435 0.944458ZM7.59728 5.32306V15.7222L1.52588e-05 11.3436V0.944462L7.59728 5.32306Z"
                    fill="#CCCCCC" />
            </svg>
            <svg className="union2p" width="26" height="16" viewBox="0 0 26 16" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd"
                    d="M7.59726 15.7222L25.6408 15.7222L18.0435 11.3436L-1.14441e-05 11.3436L7.59726 15.7222ZM18.0435 11.3436L18.0435 0.944388L25.6408 5.32299L25.6408 15.7222L18.0435 11.3436Z"
                    fill="black" />
            </svg>
        </div>

        </NavLink>
    
    </li>

    

      <li>
        <NavLink to="/inicio" id='inicio'>Inicio</NavLink>
      </li>
      <li>
      

      <NavLink  to="/quienessomos" id='quienes'>
        Quiénes somos?
        </NavLink>
      </li>
      <li>
      <NavLink to="/contacto" id='contacto'>Contacto</NavLink>
      </li>

      
   



</ul>


</nav>

)}

