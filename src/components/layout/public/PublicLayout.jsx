import React from "react";
import { Nav } from "./Nav";
import { Navigate, Outlet } from "react-router-dom";
import useAuth from "../../../hooks/useAuth";

export const PublicLayout = () => {
  const { auth } = useAuth();

  return (
    <div className="flex flex-col">
      {/* LAYOUT*/}
      <Nav />
      {/* CONTENIDO PRINCIPAL*/}
      {//<section className="layout_content"></section>
      }
      <section className="">
        {/* {!auth._id ? */}
        <Outlet />
        {/* :
        <Navigate to="/social" />
        }
        */}
      </section>
    </div>
  );
};
