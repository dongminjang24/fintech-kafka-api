FROM nginx:latest

COPY default.conf /etc/nginx/conf.d/default.conf

CMD ["nginx", "-g", "daemon off;"]

## docker build -t nginxtest:1.0 .