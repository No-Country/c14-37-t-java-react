import React from 'react'
import { useParams } from 'react-router-dom'

export const MiLista = () => {
  const { memberId } = useParams()
  console.log(memberId)
  return (
    <>
    
      <div className='bg-slate-600 text-red-500'>

        <h1 className="text-3xl font-bold underline" >Mi Lista</h1>
        <p> {memberId} Esta es la lista de {memberId}</p>
      </div>
    </>
  )
}
