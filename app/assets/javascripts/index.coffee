
$ ->
  $.get "/products", (data) ->
    $.each data, (index, product) ->
      $("#products").append $("<tr>").text ""
      $("#products").append $("<td>").text  product.refproduct
      $("#products").append $("<td>").text  product.name
      $("#products").append $("<td>").text  product.picture
      $("#products").append $("<td>").text  product.stock
      $("#products").append $("<td>").text  product.creationdate
    
