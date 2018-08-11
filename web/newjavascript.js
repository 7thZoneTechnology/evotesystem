/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function votefor(cand)
{
    document.getElementById("votedfor").value=cand;
    document.forms[0].submit();
}