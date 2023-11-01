import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import "./index.css"
import { QueryClient, QueryClientProvider } from "@tanstack/react-query"
import { ReactQueryDevtools } from "@tanstack/react-query-devtools"
//import './assets/fonts/fontawesome-free-6.1.2-web/css/all.css';

const queryClient = new QueryClient()
ReactDOM.createRoot(document.getElementById('root')).render(
  <QueryClientProvider client={queryClient}>

    <App />
    <ReactQueryDevtools />
  </QueryClientProvider>
 
)
