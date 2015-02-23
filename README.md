To run the tests on ESB, start the ESB and create a Proxy service with the following configuration. 

<?xml version="1.0" encoding="UTF-8"?>
<proxy xmlns="http://ws.apache.org/ns/synapse"
       name="ESBHttpComplianceTest"
       transports="https,http"
       statistics="disable"
       trace="disable"
       startOnLoad="true">
   <target>
      <inSequence>
         <property name="ContentType" value="text/xml" scope="axis2" type="STRING"/>
         <switch source="$axis2:HTTP_METHOD">
            <case regex="GET">
               <property name="HTTP_METHOD" value="GET" scope="axis2" type="STRING"/>
               <send>
                  <endpoint>
                     <address uri="http://localhost:3000/" format="pox"/>
                  </endpoint>
               </send>
            </case>
            <case regex="POST">
               <property name="HTTP_METHOD" value="POST" scope="axis2" type="STRING"/>
               <send>
                  <endpoint>
                     <address uri="http://localhost:3000/post" format="pox"/>
                  </endpoint>
               </send>
            </case>
            <case regex="HEAD">
               <property name="HTTP_METHOD" value="HEAD" scope="axis2" type="STRING"/>
               <send>
                  <endpoint>
                     <address uri="http://localhost:3000/" format="pox"/>
                  </endpoint>
               </send>
            </case>
            <case regex="PUT">
               <property name="HTTP_METHOD" value="PUT" scope="axis2" type="STRING"/>
               <send>
                  <endpoint>
                     <address uri="http://localhost:3000/put" format="pox"/>
                  </endpoint>
               </send>
            </case>
            <case regex="DELETE">
               <property name="HTTP_METHOD" value="DELETE" scope="axis2" type="STRING"/>
               <send>
                  <endpoint>
                     <address uri="http://localhost:3000/delete" format="pox"/>
                  </endpoint>
               </send>
            </case>
            <default/>
         </switch>
      </inSequence>
      <outSequence>
         <send/>
      </outSequence>
   </target>
   <description/>
</proxy>


