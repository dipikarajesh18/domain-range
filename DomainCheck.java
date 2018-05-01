import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.RDFNode; //for list type RDFnode
import java.util.*; //for list
//import java.io.*; //for output streams
public class DomainCheck {
  // System.out.println(key + ": " + Collections.frequency(result, key) + "  " + k);
if(max < k){
                 max = k;
                 currKey = key;
                }
 
else if (max==k){
 
String sparqlQueryString2 = " SELECT ?subject" +
" WHERE { " +
    "?subject rdfs:subClassOf" + input +  "/"+ key + " . " +
" } " ;
 
Query query2 = QueryFactory.create(sparqlQueryString2);
QueryExecution qexec2 = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql/", query2);
 
List<String> result2 = new ArrayList<String>();
ResultSet rs2 = qexec2.execSelect();
for ( ; rs2.hasNext() ; )
{
  QuerySolution soln2 = rs2.nextSolution();
  RDFNode a2 = soln2.get("subject") ;
  //System.out.println(a.asNode().getLocalName());
  result2.add(a2.asNode().getLocalName().toString());
}
boolean retval = result2.contains(currKey);
if(retval==true){
//max is a subclass no change
}
else{
String sparqlQueryString3 = " SELECT ?subject" +
" WHERE { " +
    "?subject rdfs:subClassOf" + input +  "/"+ currKey + " . " +
" } " ;
 
Query query3 = QueryFactory.create(sparqlQueryString3);
QueryExecution qexec3 = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql/", query3);
 
List<String> result3 = new ArrayList<String>();
ResultSet rs3 = qexec3.execSelect();
for ( ; rs3.hasNext() ; )
{
  QuerySolution soln3 = rs3.nextSolution();
  RDFNode a3 = soln3.get("subject") ;
  //System.out.println(a.asNode().getLocalName());
  result3.add(a3.asNode().getLocalName().toString());
}
boolean retval2 = result2.contains(key);
if(retval2==true){
//key is a subclass
max = k;
                currKey = key;
}
else{
//OWL : Thing
max = 0;
currKey = "NULL";
}
}
 
}
 
}
if(max>=0.96) {
System.out.println("The maximum occurrence is "  + currKey + " with normalised frequency of " + max);
}
else{
System.out.println("OWL: Thing ");
}
 
qexec.close() ;
scan.close();
}


}
