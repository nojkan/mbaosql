package services;


import play.db.*;
import java.io.*;
import java.sql.*;
import play.mvc.*;


import play.libs.Json;	
import play.libs.Json.*;	

import com.fasterxml.jackson.databind.JsonNode;

import models.Product;

import javax.inject.Inject;



public class ProductService  {

	
	
	public static String selectProductByID(Database db, String inRefProduct) throws SQLException {

	
		System.out.println("input " + inRefProduct);

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String result="vide2";



		String selectSQL = "SELECT row_to_json(PRODUCT) FROM PRODUCT WHERE refproduct = ?;";

		try {
			System.out.println("debut try ");

			dbConnection = db.getConnection();
			
			System.out.println("fin get Sconnection");
			
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			System.out.println("fin preparestatement");
			
			preparedStatement.setString(1,inRefProduct);
			System.out.println("fin setString");


			// execute select SQL stetement
			
			System.out.println("test ");

			 ResultSet rs = preparedStatement.executeQuery();



			//String test = rs.getString(1);
			System.out.println("test "+ rs.toString());

			while (rs.next()) {

				System.out.println("testedv");

				/*resProduct = new Product();
				resProduct.setRef(rs.getString("refproduct"));
				resProduct.setName(rs.getString("name"));
				resProduct.setPicture(rs.getString("creationdate"));
				//resProduct.setStock(rs.getStock("stock"));

				//String name = rs.getString("name");*/
				result = rs.getString(1);

				System.out.println("rs json : " + result);
				
			}



		

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

			

		}
		return result;

	}


	public static String updateProductRecordsFromJson(Database db, String inJson) throws SQLException {

		System.out.println("inJson as text" + inJson);

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String returnCode = "99";


		String selectSQL = "insert into product select * from json_populate_recordset(null::product,?::json);";

							
		try {
			dbConnection = db.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);

			preparedStatement.setString(1,inJson);

			// execute select SQL stetement
			int ireturnCode = preparedStatement.executeUpdate();
			returnCode = ireturnCode + "";
			System.out.println("updateretrun code" + returnCode);

			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return returnCode;

	}


}