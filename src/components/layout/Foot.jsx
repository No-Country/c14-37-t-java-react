import React from "react";
/* import ItemsContainer from "./ItemsContainer";
import SocialIcons from "./SocialIcons";
import { Icons } from "./Menus"; */

const Foot = () => {
  return (
   /*  <footer className=" bg-sky-300 py-7 text-white  w-full shadow-md  fixed  bottom-0 left-0'">
      <div className="md:flex md:justify-between md:items-center sm:px-12 px-4  bg-sky-300 py-7      items-center justify-between pmd:px-10">
        <h1
          className="lg:text-4xl text-3xl md:mb-0 mb-6 lg:leading-normal font-semibold
         md:w-2/5"
        >
          <span className="text-teal-400">Free</span> until you're ready to
          launch
        </h1>
        <div>
    
        </div>
      </div>
     
      <div
        className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-10
      text-center pt-2 text-gray-400 text-sm pb-8"
      >
        <span>© 2020 Appy. All rights reserved.</span>
        <span>Terms · Privacy Policy</span>
     
      </div>
    </footer> */
<>
<div className='shadow-md w-full fixed bottom-0 left-0 h-36'>
  <div className=' items-center justify-between bg-blue-300 md:px-10 px-7'>
  <img className='mx-auto  ' src="/src/assets/img/LISTA CHECK-logos 3.png" alt="Texto alternativo de la imagen" />
  <hr class="border border-black h-0.5" />

  <div className="mx-auto font-bold    text-center  text-blue-900 text-sm">
<span>© 2023  LISTACHECK Appy. All rights reserved.</span>

</div>


    <div className='font-bold text-2xl  flex font-[Poppins] text-gray-800 py-16 '>
      <div className='mx-auto  pb-60 '>


<hr className=" bg-black "/>

      </div>
    </div>

  </div>

</div>


</>
  );
};

export default Foot;