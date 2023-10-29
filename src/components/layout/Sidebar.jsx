import React from 'react'

export const Sidebar = () => {
  return (
    <aside className="lateral">

    <form className="botonera">

        <h3 className="no-tienes-cuenta" >
            ¿No tienes cuenta? </h3>

        <a href="#">
            <div className="button">

                <div className="rectangle-2">
                </div>
                <div className="register">
                    Registrarte </div>
            </div>
        </a>

        <h3  className="ya-tienes-cuenta" >
            ¿Ya tienes cuenta? </h3>

            
        <a href="#">
            <div className="button-1">
                <div className="rectangle-1">
                </div>
                <div className="join-today">
                    Iniciar Sesión </div>
            </div>
        </a>

    </form>

</aside>
  )
}
