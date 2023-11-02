import React, { useState } from 'react'
import { useForm } from '../../hooks/useForm'
import { Global } from '../../helpers/Global';
import useAuth from '../../hooks/useAuth';

export const Login = () => {

// const {compartido}=useAuth();

  const {form, changed}= useForm({});
const [saved, setSaved]=useState("not_sended");

const {setAuth}=useAuth();

  const loginUser=async(e)=>{
    e.preventDefault();

    //datos del formulario
let userToLogin=form;

//peticion al backend
const request= await fetch(Global.url + 'user/login',{
  method:"POST",
  body: JSON.stringify(userToLogin),
  headers: {
    "Content-Type": "application/json"
  }
}
)

const data = await request.json();


if(data.status =="sucess"){

  //persistir los datos en el navegador
localStorage.setItem("token" , data.token);
localStorage.setItem("user" , JSON.stringify(data.user));


  setSaved("login")

  //set datos en el auth
setAuth(data.user);

  //redireccion
  setTimeout(()=>{
    window.location.reload();
  },1500)


}else{
  setSaved("error")
}
/* console.log(data)


    console.log(form) */
  }


  return (
  <>
  {/* <h2>{compartido}</h2> */}
  <div className='marcologin'>

  {saved=="login" ?
<strong className='alert alert-sucess'>usuario identificado correctamente!!!</strong>
:''}

{saved=="error" ?
<strong className='alert alert-danger'>usuario no se ha identificado !!!</strong>
:''}


<form  onSubmit={loginUser}>


 <div >

 <input type="email" className="rectangle-30log" name="mail" placeholder="Correo electrónico" onChange={changed}/>

 </div>
  
 <div  >
 <input type="password" className="rectangle-31log" name="password" placeholder="Contraseña" onChange={changed} />

</div>
<p class="olvid-mi-contrase-a" >
Olvidé mi contraseña </p>


 <div  >
 <input type='submit' value="identificate"className='ingresar2'/>

</div>

</form>

  </div>

  </>

  )
}
