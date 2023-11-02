import React from 'react'
import useAuth from '../../hooks/useAuth'

export const Footer = () => {
const {auth}=useAuth();

// console.log(auth)

  return (

   
<footer className="footer">
 
 <div className="footer-c" >
    <div className="ellipse" >
    </div>
    <div className="sample-logo" >
          <div className="photo" >
LOGO </div>
          <svg className="union" width="31" height="24" viewBox="0 0 31 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fillRule="evenodd" clipRule="evenodd" d="M21.4186 0.962952H8.58307e-06L9.01835 7.63511H30.4369L21.4186 0.962952ZM9.01834 7.63511V23.4815L0 16.8093V0.962956L9.01834 7.63511Z" fill="#CCCCCC"/>
          </svg>
          <svg className="union2" width="31" height="24" viewBox="0 0 31 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fillRule="evenodd" clipRule="evenodd" d="M9.01832 23.4815L30.4369 23.4815L21.4185 16.8093L-1.71661e-05 16.8093L9.01832 23.4815ZM21.4186 16.8093L21.4186 0.962954L30.4369 7.63511L30.4369 23.4815L21.4186 16.8093Z" fill="black"/>
          </svg>
    </div>
    <div className="rectangle" >
    </div>
    <div className="raz-n-social-compa-ia-a-o" >
Razón social .............    /     Compañia .....................      /      Año </div>
</div>
</footer>
  )
}





/* import React from "react";

import useAuth from '../../hooks/useAuth'

const Footer = () => {
      const {auth}=useAuth();
  return (
    <footer className="bg-gray-900 text-white">
      <div className="md:flex md:justify-between md:items-center sm:px-12 px-4 bg-[#ffffff19] py-7">
        <h1
          className="lg:text-4xl text-3xl md:mb-0 mb-6 lg:leading-normal font-semibold
         md:w-2/5"
        >
          <span className="text-teal-400">Free</span> until you're ready to
          launch
        </h1>
        <div>
          <input
            type="text"
            placeholder="Enter Your ph.no"
            className="text-gray-800
           sm:w-72 w-full sm:mr-5 mr-1 lg:mb-0 mb-4 py-2.5 rounded px-2 focus:outline-none"
          />
          <button
            className="bg-teal-400 hover:bg-teal-500 duration-300 px-5 py-2.5 font-[Poppins]
           rounded-md text-white md:w-auto w-full"
          >
            Request Code
          </button>
        </div>
      </div>
      <ItemsContainer />
      <div
        className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-10
      text-center pt-2 text-gray-400 text-sm pb-8"
      >
        <span>© 2020 Appy. All rights reserved.</span>
        <span>Terms · Privacy Policy</span>
        <SocialIcons Icons={Icons} />
      </div>
    </footer>
  );
};

export default Footer; */