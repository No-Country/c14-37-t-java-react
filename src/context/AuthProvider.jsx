import React from 'react'
import {useState, useEffect, createContext } from 'react'
import { Global } from '../helpers/Global';


const AuthContext=createContext();



export const AuthProvider = ({children}) => {
// const [compartido, setCompartido]=useState("Compartida en todos los componentes");

// const [compartido, setCompartido]=useState({});

const [auth,setAuth]=useState({})
const [loading , setLoading]= useState(true);

useEffect(()=>{
    authUser();

},[]);

const authUser= async() =>{
//sacar datos usuario identificado del localstorage
const token=localStorage.getItem("token");
const user=localStorage.getItem("user")


//comprobar si tengo el token y el user
if(!token || !user){
    setLoading(false);

    return false;
}
//transformar los datos o un objeto de js
const userObj=JSON.parse(user);
const userId= userObj.id;


//peticion ajax al backend  que compruebe el token y que me devuelva todos los datos del usuario
const request=await fetch(Global.url + "user/profile/" + userId,{
    method: "GET",
    headers:{
        "Content-Type":"application/json",
        "Authorization" :token
    }
})

const data=await request.json();

console.log(data.user);

//setear el estado de auth

setAuth(data.user);
setLoading(false);

}

  return (<AuthContext.Provider
    value={{
        // compartido
        auth,
        setAuth,
        loading

    }}
    >
        {children}
    </AuthContext.Provider>
  )
}


export default AuthContext;