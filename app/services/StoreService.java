package services;


import play.db.*;
import java.io.*;
import java.sql.*;
import play.mvc.*;


import play.libs.Json;	
import play.libs.Json.*;	

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import models.Store;

import javax.inject.Inject;





public class StoreService  {

	
	
	public static String selectStoreByID(Database db, String inRefStore) throws SQLException {

	
		System.out.println("input " + inRefStore);

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String result="vide2";



		String selectSQL = "SELECT row_to_json(STORE) FROM STORE WHERE refstore = ?;";

		try {
			System.out.println("debut try ");

			dbConnection = db.getConnection();
			
			System.out.println("fin get Sconnection");
			
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			System.out.println("fin preparestatement");
			
			preparedStatement.setString(1,inRefStore);
			System.out.println("fin setString");


			// execute select SQL stetement
			
			System.out.println("test ");

			 ResultSet rs = preparedStatement.executeQuery();

			
			//String test = rs.getString(1);
			System.out.println("test "+ rs.toString());

			while (rs.next()) {

				System.out.println("testedv");

				/*resStore = new Store();
				resStore.setRef(rs.getString("refstore"));
				resStore.setName(rs.getString("name"));
				resStore.setPicture(rs.getString("creationdate"));
				//resStore.setStock(rs.getStock("stock"));

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


	public static ArrayNode selectAllStoreJSON(Database db) throws SQLException {

	
	

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String result="vide2";
		ArrayNode jsResult = null;



		String selectSQL = "SELECT row_to_json(STORE) FROM STORE";

		try {
			System.out.println("debut try ");

			dbConnection = db.getConnection();
			
			System.out.println("fin get Sconnection");
			
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			System.out.println("fin preparestatement");
			

			// execute select SQL stetement

			 //ArrayNode jsResult = Json.newArray();
			//ObjectMapper mapper = new  ObjectMapper();
			//jsResult = mapper.createArrayNode();
			jsResult = Json.newArray();
		

			
			System.out.println("test ");

			 ResultSet rs = preparedStatement.executeQuery();



			
			while (rs.next()) {

				System.out.println("testedv");

				/*resStore = new Store();
				resStore.setRef(rs.getString("refstore"));
				resStore.setName(rs.getString("name"));
				resStore.setPicture(rs.getString("creationdate"));
				//resStore.setStock(rs.getStock("stock"));

				//String name = rs.getString("name");*/
				result = rs.getString(1);
				jsResult = jsResult.add(result);

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
		return jsResult;
	
	}



	public static String updateStoreRecordsFromJson(Database db, String inJson) throws SQLException {

		System.out.println("inJson as text" + inJson);

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String returnCode = "99";


		String selectSQL = "insert into store select * from json_populate_recordset(null::store,?::json);";

							
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