import React, { useState } from 'react'

import { useForm } from '../../hooks/useForm'
import { Global } from '../../helpers/Global';

export const Register = () => {

    const {form,changed}=useForm({});
    const [saved, setSaved]= useState("not_sended");

    const saveUser =async(e)=>{
        e.preventDefault();

        //Recoger datos del formulario
        let newUser=form;

        //Guardar usuarios en el backend
        const request=await fetch(Global.url+  "user/register", {
            method:"´POST",
            body: JSON.stringify(newUser),
            headers:{
                "Content-Type": "application/json"
            }
        });

        const data =await request.json();
        console.log(data)

if(data.status=="sucess"){
    setSaved("saved")
}else{
    setSaved("error")
}

    } // fin del metodo de guardar

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


    <form className="formulario" onSubmit={saveUser}>
    <div className="marco mt-28" >
        <div className="crear-cuenta" >
            Crear cuenta </div>

            <div className='inputsform'>
            <div className="frame-nome" >
                <input type="text" className="nombre" name="nombre" placeholder="Nombre (s)" onChange={changed}/>
                </div>


                <div className="frame-ape" >
                    <input type="text" className="apellido" name="apellido" placeholder="Apellido (s)" onChange={changed} />

                    </div>


 <div className="frame-mail" >
    <input type="email" className="mail" name="mail" placeholder="Correo electrónico" onChange={changed}/>

</div>





<div className="frame-20pass" >
    <div className="frame-23pass" >
        <input type="password" className="pass" name="password" placeholder="Crear contraseña" onChange={changed}/>

    </div>
</div>


</div>


{/*in radios */}

<div className='inradios'>

<div className="eva-radio-button-on-fill" >
    <div className="eva-radio-button-on-fill-0" >
          <div className="eva-radio-button-on-fill-1" >
             <input type="radio" className="radio" />
          </div>
    </div>
</div>


<div className="mantener-mi-sesi-n-abierta" >
    Mantener mi sesión abierta </div>


   
 <div className="eva-radio-button-off-outline" >
    <div className="eva-radio-button-off-outline-0" >
        <input type="radio" className="radio2" />

    </div>
</div>


<div className="enviar-correos-el-ctronicos-sobre-novedades-de-temporada-art-culos-promociones-y-m-s" >
    Enviar correos eléctronicos sobre novedades de temporada, artículos, promociones y más. </div>


    </div>

    <div className='botonesform'>
  
 <div className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad" >
    <span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span">Al crear una cuenta, recuerda haber leído detalladamento los </span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span2">Terminos</span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span3">
          </span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span4">y</span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span5">
          </span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span6">condiciones</span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span7"> y </span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span8">Aviso</span>
          <span className="al-crear-una-cuenta-recuerda-haber-le-do-detalladamento-los-terminos-y-condiciones-y-aviso-de-seguridad-span9"> de seguridad</span>
    </span>
</div>




    <div className="buttoncrear" >
       
          <div className="join-today-crear" >
            <input type='submit' value='Crear cuenta' className="frame-crear  rectangle-crear join-today-crear " />
</div>
    </div>




<div className="ya-tienes-cuenta-crear" >
    ¿Ya tienes cuenta? </div>


   
 <div className="frame-iniciarc" >
    <div className="button-iniciarc" >
          <div className="rectangle-iniciarc" >
          </div>
          <div className="join-today-iniciarc" >
Iniciar Sesión </div>
    </div>
</div>

</div>

    </div>

</form>
</div>
  )
}
