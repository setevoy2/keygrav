FROM richarvey/nginx-php-fpm
COPY . /var/www/html
RUN php /var/www/html/bin/grav install
EXPOSE 443 80
CMD ["/start.sh"]
