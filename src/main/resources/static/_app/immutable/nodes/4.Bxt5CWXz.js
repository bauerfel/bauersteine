import{s as P,n as M,c as N,o as R}from"../chunks/scheduler.sluXByI4.js";import{S as Y,i as F,e as T,s as C,c as k,l as O,f as B,a as E,d as b,m as J,g as D,h as p,q as K,t as S,b as A,j as I,o as Q}from"../chunks/index.Vlo5ODvd.js";import{e as q}from"../chunks/each.D6YF6ztN.js";import{a as w}from"../chunks/axios.B6xwUs71.js";import{p as V}from"../chunks/stores.D-hmOlbf.js";import{j as W}from"../chunks/store.cIuNT0ob.js";function x(i,e,c){const a=i.slice();return a[2]=e[c],a}function G(i){let e,c="Bezahlen",a,r;function f(){return i[3](i[2])}return{c(){e=T("button"),e.textContent=c},l(s){e=k(s,"BUTTON",{"data-svelte-h":!0}),O(e)!=="svelte-g7uarh"&&(e.textContent=c)},m(s,u){D(s,e,u),a||(r=Q(e,"click",f),a=!0)},p(s,u){i=s},d(s){s&&b(e),a=!1,r()}}}function U(i){let e,c,a=i[2].id+"",r,f,s,u=i[2].state+"",_,m,n,t=i[2].urneIds+"",o,l,g,y,d=i[2].state==="ASSIGNED"&&G(i);return{c(){e=T("tr"),c=T("td"),r=S(a),f=C(),s=T("td"),_=S(u),m=C(),n=T("td"),o=S(t),l=C(),g=T("td"),d&&d.c(),y=C()},l(v){e=k(v,"TR",{});var h=E(e);c=k(h,"TD",{});var j=E(c);r=A(j,a),j.forEach(b),f=B(h),s=k(h,"TD",{});var z=E(s);_=A(z,u),z.forEach(b),m=B(h),n=k(h,"TD",{});var H=E(n);o=A(H,t),H.forEach(b),l=B(h),g=k(h,"TD",{});var L=E(g);d&&d.l(L),L.forEach(b),y=B(h),h.forEach(b)},m(v,h){D(v,e,h),p(e,c),p(c,r),p(e,f),p(e,s),p(s,_),p(e,m),p(e,n),p(n,o),p(e,l),p(e,g),d&&d.m(g,null),p(e,y)},p(v,h){h&1&&a!==(a=v[2].id+"")&&I(r,a),h&1&&u!==(u=v[2].state+"")&&I(_,u),h&1&&t!==(t=v[2].urneIds+"")&&I(o,t),v[2].state==="ASSIGNED"?d?d.p(v,h):(d=G(v),d.c(),d.m(g,null)):d&&(d.d(1),d=null)},d(v){v&&b(e),d&&d.d()}}}function X(i){let e,c="Deine Bestellungen",a,r,f,s='<tr><th scope="col">Bestellungnummer</th> <th scope="col">State</th> <th scope="col">UrneIds</th> <th scope="col">Bezahlen</th></tr>',u,_,m=q(i[0]),n=[];for(let t=0;t<m.length;t+=1)n[t]=U(x(i,m,t));return{c(){e=T("h1"),e.textContent=c,a=C(),r=T("table"),f=T("thead"),f.innerHTML=s,u=C(),_=T("tbody");for(let t=0;t<n.length;t+=1)n[t].c();this.h()},l(t){e=k(t,"H1",{"data-svelte-h":!0}),O(e)!=="svelte-1y38g11"&&(e.textContent=c),a=B(t),r=k(t,"TABLE",{class:!0});var o=E(r);f=k(o,"THEAD",{"data-svelte-h":!0}),O(f)!=="svelte-7n66is"&&(f.innerHTML=s),u=B(o),_=k(o,"TBODY",{});var l=E(_);for(let g=0;g<n.length;g+=1)n[g].l(l);l.forEach(b),o.forEach(b),this.h()},h(){J(r,"class","table")},m(t,o){D(t,e,o),D(t,a,o),D(t,r,o),p(r,f),p(r,u),p(r,_);for(let l=0;l<n.length;l+=1)n[l]&&n[l].m(_,null)},p(t,[o]){if(o&3){m=q(t[0]);let l;for(l=0;l<m.length;l+=1){const g=x(t,m,l);n[l]?n[l].p(g,o):(n[l]=U(g),n[l].c(),n[l].m(_,null))}for(;l<n.length;l+=1)n[l].d(1);n.length=m.length}},i:M,o:M,d(t){t&&(b(e),b(a),b(r)),K(n,t)}}}function Z(i,e,c){let a,r;N(i,W,t=>c(4,a=t)),N(i,V,t=>c(5,r=t));const f=r.url.origin;let s=[],u={id:"",urneIds:[],state:""};R(()=>{_()});function _(){var t={method:"get",url:f+"/api/order",headers:{},headers:{Authorization:"Bearer "+a}};w(t).then(function(o){c(0,s=o.data)}).catch(function(o){alert("Could not get orders"),console.log(o)})}function m(t){var o={method:"post",url:f+`/api/service/${t}/pay`,headers:{Authorization:"Bearer "+a}};w(o).then(function(l){alert("Order paid"),_()}).catch(function(l){alert("Could not pay order"),console.log(l)})}return[s,m,u,t=>m(t.id)]}class at extends Y{constructor(e){super(),F(this,e,Z,X,P,{})}}export{at as component};
