#this is the mod file.

set student;
set group;
set language;
set leadership;
set style;

var x{student, group} >=0, <=1, integer;
var U{group, language} >=0, <=1, integer;
var V{group, leadership} >=0, <=1, integer;
var W{group, style} >=0, <=1, integer;


param A{student, language};
param B{student, leadership};
param C{student, style};
param FOUR;
param ONE;


maximize diversity: sum{j in group, k in language}U[j,k] 
                  + sum{j in group, l in leadership}V[j,l] 
                  + sum{j in group, m in style}W[j,m];

subject to LanguageDiversity{j in group, k in language}: 
                         sum{i in student}A[i,k]*x[i,j] >= U[j,k];
subject to LeadershipDiversity{j in group, l in leadership}: 
                         sum{i in student}B[i,l]*x[i,j] >= V[j,l];
subject to StyleDiversity{j in group, m in style}: 
                         sum{i in student}C[i,m]*x[i,j] >= W[j,m];                       
subject to MaxGroup{j in group}:
                         sum{i in student}x[i,j] <= FOUR;
subject to MaxOne{i in student}:
                         sum{j in group}x[i,j] = ONE;
