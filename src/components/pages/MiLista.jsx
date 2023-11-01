import React,{useState} from "react";
import { useParams } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faTrash, faUpload } from "@fortawesome/free-solid-svg-icons"
import "../../index.css";

import {
  useQuery,
  useMutation,
  useQueryClient,
  QueryClient,
  QueryClientProvider,
} from "@tanstack/react-query";

import { getLists, getList } from "../../api/listas.js";

export const MiLista = () => {
  const [newProductName, setNewProductName] = useState('')
  const [newProductQuantity, setNewProductQuantity] = useState()
  const [newProductCategory, setNewProductCategory] = useState('')
  const [newProductBrand, setNewProductBrand] = useState('')
  const [newProductNotes, setNewProductNotes] = useState('')
  const { memberId } = useParams();
  //console.log(memberId)

  const listQuery = useQuery({
    queryKey: ["list", memberId],
    queryFn: () => getList(memberId),
  });

  if (listQuery.status === "loading") return <h1>Loading...</h1>;
  if (listQuery.status === "error") {
    return <h1>{JSON.stringify(listQuery.error)}</h1>;
  }



  console.log(listQuery.data);
  const handleSubmit = (e) => {
    e.preventDefault();
    addTodoMutation({ userId: 1, title: Product, completed: false, id: 9999 });
    setNewProductName("");
    setNewProductQuantity();
    setNewProductBrand("");
  };

  const newItemSection = (
    <form onSubmit={handleSubmit} className=" border-solid border-cyan-500">
      <label htmlFor="new-todo">Ingrese un nuevo producto a la lista</label>
      <div className="flex w-full gap-3 border-red-500">

        <div className="text-red-400">
          <input
            type="text"
            id="new-todo"
            value={newProductName}
            onChange={(e) => setNewProductName(e.target.value)}
            placeholder="Nombre del producto"
          />
        </div>
        <div className="">
          <input
            type="text"
            id="new-ProductQuantity"
            value={newProductQuantity}
            onChange={(e) => setNewProductQuantity(e.target.value)}
            placeholder="Cantidad"
          />
        </div>
        <div className="">
          <input
            type="text"
            id="new-ProductCategory"
            value={newProductCategory}
            onChange={(e) => setNewProductCategory(e.target.value)}
            placeholder="Categoria"
          />
        </div>

        <div className="">
          <input
            type="text"
            id="new-ProductBrandName"
            value={newProductBrand}
            onChange={(e) => setNewProductBrand(e.target.value)}
            placeholder="Marca del Producto" 
          />
        </div>
        <div className="">
          <input
            type="text"
            id="new-ProductNotes"
            value={newProductNotes}
            onChange={(e) => setNewProductNotes(e.target.value)}
            placeholder="Notas"
          />
        </div>
        <button className="submit">
          <FontAwesomeIcon icon={faUpload} />
        </button>
      </div>
    </form>
  );
  
  return (
    <div className="flex border-solid border-2 border-sky-500 rounded-md m-5" >
      <div className="w-full">
        <h1 className="bg-sky-600 rounded-md m-5 text-white mx-60">
          {listQuery.status === "success" &&
            listQuery.data.shopListName}
        </h1>
        <p className=""> Soy una Lista </p>
        <p>
          {memberId} Esta es la lista de {memberId}
        </p>
        {newItemSection}
        <ul className="w-full">
          {listQuery.status === "success" &&
            listQuery.data.products.map((list) => (
              <li key={list.id_product} className="w-full border-solid border-2 border-sky-500">
                <div className="columns-6  justify-around">
                  <input
                    type="checkbox"
                    checked={list.bought}
                    id={list.id_product}
                  />
                  <div>{list.name_product}</div>
                  <div>{list.quantity}</div>
                  <div>{list.category.categoryName}</div>
                  <div>{list.brand.brandName}</div>
                  <div>{list.note.noteField}</div>
                </div>
              </li>
            ))}
        </ul>
      </div>
    </div>
  );
};
