import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const NavPublic = () => {
  let Links = [
    { name: 'Inicio', link: '/' },
    { name: 'Quiénes somos?', link: '/quienessomos' },
    { name: 'Contacto', link: '/contacto' },
  
  ];

  let [open, setOpen] = useState(false);

  return (
    <div className='shadow-md w-full fixed top-0 left-0'>
      <div className='md:flex items-center justify-between bg-rose-300 py-4 md:px-10 px-7'>
        <div className='font-bold text-2xl cursor-pointer flex items-center font-[Poppins] text-gray-800'>
          <span className='text-3xl text-indigo-600 mr-1 pt-2'>
            <img src="/src/assets/img/LISTA CHECK-logos 3.png" alt="Texto alternativo de la imagen" />
          </span>
        </div>

        <div onClick={() => setOpen(!open)} className='text-3xl absolute right-8 top-6 cursor-pointer md:hidden'>
          <ion-icon name={open ? 'close' : 'menu'}></ion-icon>
        </div>

        <ul className={`md:flex md:items-center md:pb-0 pb-12 absolute md:static bg-rose-300 md:z-auto z-[-1] left-0 w-full md:w-auto md:pl-0 pl-9 transition-all duration-500 ease-in ${open ? 'top-20 ' : 'top-[-490px]'}`}>
          {Links.map((link) => (
            <li key={link.name} className='md:ml-8 text-xl md:my-0 my-7'>
              <Link to={link.link} className='text-blue-600 hover:text-gray-400 duration-500'>
                {link.name}
              </Link>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default NavPublic;
