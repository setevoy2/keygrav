FROM richarvey/nginx-php-fpm
COPY . /var/www/html
RUN ls -l /var/www/html/user/plugins
EXPOSE 443 80
CMD ["/start.sh"]
