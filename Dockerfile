FROM richarvey/nginx-php-fpm
COPY . /var/www/html
EXPOSE 443 80
CMD ["/start.sh"]
