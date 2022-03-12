import axios from "axios";
import {useState,useEffect} from "react";
import MovieCard from "components/MovieCard";
import Pagination from "components/pagination";
import { BASE_URL} from "utils/requests";
import { MoviePage } from "types/movie";


function Listing(){
    
    const [pageNumber, setPageNumber] = useState(0);

    useEffect(()=>{
        axios.get(`${BASE_URL}/movies`)
        .then(response => {
            const data = response.data as MoviePage;
            setPageNumber(data.number);
        });
    },[]);

     const movie = {
      id:1,
      image : "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg",
      title : "The Witcher",
      count : 2,
      score:4.5
     };
    
    
    return (

        <>

        <p>{pageNumber}</p>
       <Pagination/>
       <div className="container">
       <div className="row">
          <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
          <MovieCard movie={movie}/>
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3  mb-3">
          <MovieCard movie={movie}/>
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3  mb-3">
          <MovieCard movie={movie}/>
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3  mb-3">
          <MovieCard movie={movie}/>
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3  mb-3">
          <MovieCard movie={movie}/>
          </div>
       </div>
       </div>
      
        </>
        
    );
   }
   export default Listing;