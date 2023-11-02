import React, { useState } from 'react'
import useAuth from '../../hooks/useAuth';
import { Global } from '../../helpers/Global';

export const Config = () => {

    const {auth}=useAuth();
const [saved, setSaved]= useState("not_saved");

const updateUser =(e)=> {
e.preventDefault();
console.log(auth)

}

  return (
    <div>
    {/* <Nav/> */}
{saved=="saved" ?
<strong className='alert alert-sucess'>usuario registrado correctamente!!!</strong>
:''}

{saved=="error" ?
<strong className='alert alert-danger'>usuario no se ha registrado !!!</strong>
:''}



   {/*  <strong className='alert alert-sucess'>{saved=="saved" ? "usuario registrado correctamente!!!":" "}</strong>
    <strong className='alert alert-danger'>{saved=="error" ? "usuario no se ha registrado !!":" "}</strong> */}


    <form className="formulario" onSubmit={updateUser}>
    <div className="marco" >
        <div className="crear-cuenta" >
            Ajustes </div>

            <div className='inputsform'>
            <div className="frame-nome" >
                <input type="text" className="nombre" name="nombre" placeholder="Nombre (s)" defaultValue={auth.nombre} />
                </div>


                <div className="frame-ape" >
                    <input type="text" className="apellido" name="apellido" placeholder="Apellido (s)" defaultValue={auth.apellido}/>

                    </div>


 <div className="frame-mail" >
    <input type="email" className="mail" name="mail" placeholder="Correo electrónico" defaultValue={auth.mail}/>

</div>





<div className="frame-20pass" >
    <div className="frame-23pass" >
        <input type="password" className="pass" name="password" placeholder="Crear contraseña"/>

    </div>
</div>


</div>


{/*in radios */}


    <div className='botonesform'>
  





    <div className="buttoncrear" >
       
          <div className="join-today-crear" >
            <input type='submit' value='Enviar' className="frame-crear  rectangle-crear join-today-crear " />
</div>
    </div>






   


</div>

    </div>

</form>
</div>
  )
}
