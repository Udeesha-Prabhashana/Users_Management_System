import React, { useEffect, useState } from 'react';
import axios from "axios";
import { Link, useParams } from 'react-router-dom';

export default function Home() {

  const [Users, setUsers] = useState([]);
  const { id } = useParams();

  useEffect(() => {     //when Home page is load , then will open inside of the useEffect hook
    loadUsers();
  }, []);          //if we do not give the empty array, then it will run unlimited time when page loard
 
  const loadUsers =async() => {             //unless this request is completed so it wonn't excute next line without using 'async' and 'wait'
    const result = await axios.get(`http://localhost:8080/users`);
    setUsers(result.data)
    console.log(result.data);
  }

  const HandleDelete = async (id) => {
    await axios.delete(`http://localhost:8080/user/${ id }`)
    loadUsers()
  }

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Username</th>
              <th scope="col">Email</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {Users.map((User, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{User.name}</td>
                <td>{User.username}</td>
                <td>{User.email}</td>
                <td>
                  <Link className="btn btn-primary mx-2" to={`/viewuser/${User.id}`}>View </Link>
                  <Link className="btn btn-outline-primary mx-2" to={`/editUser/${User.id}`}> Edit</Link>
                  <button className="btn btn-danger mx-2" onClick={()=> HandleDelete(User.id)}> Delete </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
