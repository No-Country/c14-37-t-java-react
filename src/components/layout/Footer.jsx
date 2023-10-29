import React from 'react'
import useAuth from '../../hooks/useAuth'

export const Footer = () => {
const {auth}=useAuth();

console.log(auth)

  return (

   
<footer className="footer">
 
 <div className="footer-c" >
    <div className="ellipse" >
    </div>
    <div className="sample-logo" >
          <div className="photo" >
LOGO </div>
          <svg className="union" width="31" height="24" viewBox="0 0 31 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M21.4186 0.962952H8.58307e-06L9.01835 7.63511H30.4369L21.4186 0.962952ZM9.01834 7.63511V23.4815L0 16.8093V0.962956L9.01834 7.63511Z" fill="#CCCCCC"/>
          </svg>
          <svg className="union2" width="31" height="24" viewBox="0 0 31 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M9.01832 23.4815L30.4369 23.4815L21.4185 16.8093L-1.71661e-05 16.8093L9.01832 23.4815ZM21.4186 16.8093L21.4186 0.962954L30.4369 7.63511L30.4369 23.4815L21.4186 16.8093Z" fill="black"/>
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
